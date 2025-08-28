#Please install pycryptodome
#use the following command in a command prompt
#pip install pycryptodome

from Crypto.Cipher import DES
from Crypto.Random import get_random_bytes
from Crypto.Util.Padding import pad
from Crypto.Util.Padding import unpad
from base64 import b64encode
from base64 import b64decode

class encryptDecrypt:
#if you need to add more methods feel free to add them
    def getADesKey(self):
        key = get_random_bytes(8)
        return key
    
    def encryptDes(self,plainText, key):
        paddedText = pad(plainText, DES.block_size)#Padding the plain text to align DES block size
        desCipher = DES.new(key, DES.MODE_ECB) #Creating the DES cipher
        return desCipher.encrypt(paddedText) #Returning the ciphered text
    
    def decryptDes(self, cipheredText, key):
        desCipher = DES.new(key, DES.MODE_ECB)
        plainText =unpad(desCipher.decrypt(cipheredText),DES.block_size)
        return plainText #Returning the plain text

    def encryptAes(self,plainText, key):
        #Update this method to complete the encryption using the AES encryption method
        return

    def decryptAes(self, cipheredText, key):
        #update this method to complete the encryption using the AES descryption method
        return
        
        
objEncrypt = encryptDecrypt() #An object of encryptDecrypt() class is created
encryptionKey= objEncrypt.getADesKey() #A random DES key is generated
plainText = b'Python is a very powerful language' #Plain text to be encrypted

#Encryption using DES algorithm
encryptedText = objEncrypt.encryptDes(plainText,encryptionKey)
encryptedText = b64encode(encryptedText).decode('utf-8')


#Decryption using DES algorithm
decodedEncryptedText= b64decode(encryptedText)
decryptedText = objEncrypt.decryptDes(decodedEncryptedText,encryptionKey)
print(decryptedText)


#Upload the updated file to the dropbox






