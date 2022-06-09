## Table  of Contents
**- [About the App](#about-the-app)**<br>
**- [General Preview](#general-preview)**<br>
**- [Technical](#technical)**<br>

## About the App
An Android app to show greetings in different languages. Supported languages are English, Kiswahili and Kimeru. :]

## General Preview
<img src="https://github.com/BKinya/Greetings-App/blob/master/img/Screenshot_20220602-152232_Greetings.jpg" width="200" alt="Greetings in Kimeru" class = "bordered">&emsp;<img src="https://github.com/BKinya/Greetings-App/blob/master/img/Screenshot_20220602-153204_Greetings.jpg" width="200" alt="Greetings in Kiswahili" class = "bordered">&emsp;<img src="https://github.com/BKinya/Greetings-App/blob/master/img/Screenshot_20220602-153155_Greetings.jpg" width="200" alt="Greetings in English" class = "bordered">



## Technical
### Running the Project
**1. Required to run project:**
      - Use Android Studio Chipmunk | 20201.2.1 or later. It will be less messy.
      
**2. Clone this repository:**
    
    HTTPS: 
    `git clone https://github.com/BKinya/Greetings-App.git`
    
    SSH: 
      `git clone  git@github.com:BKinya/Greetings-App.git`
      
    GitHub CLI:
    `gh repo clone BKinya/Greetings-App`
    
**3. Open Project in Android Studio**

**4. Build Project**

**5. In case of an error when building project, update your gradle version, Build Tools download**

### Architecture
MVVM
   
### Dependencies
1. Jetpack libraries 
	- LiveData
	- AndroidX
	- Android KTX
	- Navigation
	- ViewModel
	- DataStore: Preferences and Proto DataStores
2. Coroutines - For Concurrency and asynchronous tasks
3. Koin - For Dependency Injection
4. Protobuf - to generate code for proto schema
5. Testing Dependencies -
	- JUnit
	- AndroidX Test

## About the Author
Android Engineer | Android Author @ raywenderlich.com | Likes Crochet and Knitting. <br>
[Twitter: B__Kinya](https://twitter.com/B__Kinya) | [LinkedIn: Beatrice Kinya](www.linkedin.com/in/beatrice-kinya-93307514b)


## References/Resources
- [Guide to App architrecture](https://developer.android.com/topic/architecture)<br>
- [Jetpack DataStore(docs)](https://developer.android.com/topic/libraries/architecture/datastore)<br>
- [Slides](https://speakerdeck.com/bkinya/android-datastore)<br>
	
