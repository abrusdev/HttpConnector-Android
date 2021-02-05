# HttpConnector-Android

[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html) ![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)

Android library for working with HTTP requests in Android SDK

  - used HttpUrlConnection to send requests
  - used Jsoup to get DOM elements inside html page

USAGE
-----
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency
```groovy
dependencies {
    implementation 'com.github.abrusdev:HttpConnector-Android:0.0.4'
    implementation 'org.jsoup:jsoup:1.13.1'
}
```

JAVA
-----
```
HttpConnector.create(BASE_URL)
    .setConnectTimeout(10000)
    .setReadTimeout(10000)
    .setMethod(HttpMethod.GET)
    .get();
```

SUPPORT 🤝
-----
Find this library useful?  [**Follow me**](https://github.com/abrusdev) for my next creations 👍