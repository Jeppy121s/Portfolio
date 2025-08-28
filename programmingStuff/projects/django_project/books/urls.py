from django.urls import path
from django.contrib.auth import views as auth_views
from . import views

urlpatterns = [
    path('', views.bookstore_home, name='bookstore_home'),
    path('books/<int:book_id>/', views.book_detail, name='book_detail'),
    path('books/<int:book_id>/edit/', views.edit_book, name='edit_book'),
    path('books/<int:book_id>/delete/', views.delete_book, name='delete_book'),
    path('books/add/', views.add_book, name='add_book'),
    path('user/register/', views.register, name='register'),
    path('user/login/', auth_views.LoginView.as_view(), name='login'),
    path('user/logout/', views.logout_view, name='logout'),
]

