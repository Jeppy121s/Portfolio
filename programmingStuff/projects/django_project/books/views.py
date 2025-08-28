from django.http import HttpResponse
from django.shortcuts import render, get_object_or_404, redirect
from .models import Book
from django import forms
from django.contrib.auth.forms import UserCreationForm
from django.contrib import messages
from django.contrib.auth import logout
from django.contrib.auth.decorators import login_required
from django.http import HttpResponseForbidden


def logout_view(request):
    logout(request)
    return redirect('bookstore_home')


def register(request):
    if request.method == 'POST':
        form = UserCreationForm(request.POST)
        if form.is_valid():
            form.save()
            messages.success(request, 'Your account has been created successfully!')
            return redirect('login')
        else:
            messages.error(request, 'Please correct the errors below.')
    else:
        form = UserCreationForm()

    return render(request, 'books/register.html', {'form': form})


class BookForm(forms.ModelForm):
    class Meta:
        model = Book
        fields = ['title', 'author', 'year', 'rating', 'description']


@login_required
def delete_book(request, book_id):
    book = get_object_or_404(Book, id=book_id)
    if book.user != request.user:
        return HttpResponseForbidden("You are not allowed to delete this book.")
    if request.method == 'POST':
        book.delete()
        return redirect('bookstore_home')

    return render(request, 'books/delete_book.html', {'book': book})


@login_required
def add_book(request):
    if request.method == 'POST':
        form = BookForm(request.POST)
        if form.is_valid():
            book = form.save(commit=False)
            book.user = request.user
            book.save()
            return redirect('bookstore_home')
    else:
        form = BookForm()

    return render(request, 'books/add_book.html', {'form': form})


@login_required
def edit_book(request, book_id):
    book = get_object_or_404(Book, id=book_id)
    if book.user != request.user:
        return HttpResponseForbidden("You are not allowed to edit this book.")
    if request.method == 'POST':
        form = BookForm(request.POST, instance=book)
        if form.is_valid():
            form.save()
            return redirect('book_detail', book_id=book.id)
    else:
        form = BookForm(instance=book)

    return render(request, 'books/edit_book.html', {'form': form, 'book': book})


def bookstore_home(request):
    books = Book.objects.all()
    return render(request, 'books/homepage.html', {'books': books})


def book_detail(request, book_id):
    book = get_object_or_404(Book, id=book_id)
    return render(request, 'books/book_detail.html', {'book': book})


def index(request):
    return HttpResponse("Welcome to the Karamjit's Books App!")
