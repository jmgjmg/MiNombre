MiNombre
========

Android project created with eclipse from a Processing sketch. It includes a settings activity on top of the default Processing screen/activity

Notes
=====

+ I followed the instructions in this link (http://blog.onthewings.net/2013/04/25/setting-up-a-processing-android-project-in-eclipse/) referenced in the Prcessing wiki for Android
+ I copied the main java file from the project folder created by Processing when using "Export Android Project" 
+ I created my own manifest XML file, but you can reuse the one created by Processing using "Export Android Project".  Apparently it is important to include the <code>android:debuggable="true"</code> attribute in the <code>\<application\></code> tag
+ You can create new activities as java files (as you would do for a standard Android project). You can call these new activities from your Processing activity using Intents and calls to <code>startActivity</code> or <code>startActivityForResult</code>. Do not forget to include the new activities in the manifest XML file
+ Processing screens/activities inherit from <code>processing.core.PApplet</code> and include two main methods:
  + <code>setup</code>: executed once when the activity is frist created
  + <code>draw</code>: repeated endlessly until the activity is finished or a new activity is started
