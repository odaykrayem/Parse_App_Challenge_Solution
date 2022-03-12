# App Challenge

Quick challenge for examining your coding experience, style and quality.


# Docs
Our app uses the Parse toolkit (a database backend solution comparable to Firebase). You can find its documentation here:
- Android SDK Guide: http://docs.parseplatform.org/android/guide/#objects


# Task
Please implement a simple two-page app that uses Parse as its backend. This app's purpose is to provide a simple version of the requests that the real app we're working on contains.  First, let me describe the data model of the request. Each request has a: 
- Title (database field is called "title", mandatory, string)
- Description (database field is called "description", mandatory, string)
- Creator (database field is called "creator", string)
- Creation date (automatically added by the Parse SDK, field is called "createdAt", access it via `parseObject.getCreatedAt()`)

You do not need to create/provide a Parse database, this part is already done in the example app.

The first activity that is shown after starting the App is a list of all requests. For each request, title, description, creator and creation date should be shown. You don't need to implement a detail page, the list is enough. Feel free to think of a simple design for the list that contains all mentioned field in a user-friendly format. 

The second activity (that gets shown when the user taps on the "+"-button) is a form to create a new request. The user should be able to enter a title, description as well as his/her name. The creation date gets automatically assigned by the Parse database. The form should contain a "Post request" button that saves the request to the database. You're free to implement a design as you like that contains all fields and is user friendly. Data validation does not need to be done, except that no field should be left empty.

To reduce the work you need to do, please use the app that this repository contains as a starting point. In Android Studio, you can directly create a project from this repository. Some basic things are already implemented, thus saving some time. :) If you're not yet familiar with the way Java apps on Android work, the code in the repository gives you hints what elements you can use to implement the described functionality.

In case you have any questions or issues, feel free to send me a message at `ericschneider@kiwio.eu` or contact Maher. You can hand in the final app either as a zip archive or create a repository at Github.
