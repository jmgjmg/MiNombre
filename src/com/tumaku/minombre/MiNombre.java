package com.tumaku.minombre;

import processing.core.*; 
import processing.event.*; 

import java.util.ArrayList; 

import android.content.Intent;
import android.content.SharedPreferences;


public class MiNombre extends PApplet {

// twitter example based on http://blog.blprnt.com/blog/blprnt/updated-quick-tutorial-processing-twitter

private final int SETTINGS_ID =1;

//Build an ArrayList to hold all of the words that we get from the imported tweets
ArrayList<String> words = new ArrayList();
boolean horizontal =true;
int counter=0;
int clickCounter=0;
String nameString, surname1String, surname2String;
long lastUpdate=0;

public void setup() {
  //Set the size of the stage, and the background to black.
 
  background(0);
  smooth();
  words.add(nameString);
  words.add(surname1String);
  words.add(surname2String);  
 // words.add("0");
  updateValues();
}

public void draw() {
  if ((mousePressed) &&((millis()-lastUpdate)>3000)) {
	  clickCounter++;
	  Intent intentSettings = new Intent(this, com.tumaku.minombre.SettingsActivity.class);
	  startActivityForResult(intentSettings, SETTINGS_ID);				
	  return;			    
   }

  //Draw a faint black rectangle over what is currently on the stage so it fades over time.
  fill(0,20);
  rect(0,0,width,height);
//  words.set(3,Integer.toString(clickCounter));

  //Draw a word from the list of words that we've built
  int nbrWords= words.size();
  if(++counter>=nbrWords) counter=0;
  String word = words.get(counter);

  //Put it somewhere random on the stage, with a random size and colour
  float ts= random(30,70);
  float x= random(width);
  float y= random(height);
  textSize(ts);  
  float sw = textWidth(word);
  fill(0,0,0);
  if (horizontal) {
    translate(0,0);
    rotate (0);
    rect(x-2,y-ts-1,sw+4,ts+4);
    fill(random(255),random(255), random(255));
    text(word, x, y);
  } else {
    translate(height,0);
    rotate (PI/2);
    rect(x-2,y-ts-1,sw+4,ts+4);
    fill(random(255),random(255), random(255));
    text(word, x, y);
  
  }
  horizontal =!horizontal;
  delay(200);
}

//  public int sketchWidth() { return 400; }
//  public int sketchHeight() { return 800; }
  
  

	protected void onActivityResult(int requestCode, int resultCode, Intent data){
	 super.onActivityResult(requestCode, resultCode, data); 
	 lastUpdate=millis();
	 // See which child activity is calling us back.
	 if (requestCode==SETTINGS_ID) {
	         if (resultCode == RESULT_CANCELED) {}//DO NOTHING 
	         else {	     
	        	  fill(0,50);
	        	  rect(0,0,width,height);	         	
	        	  updateValues();
	              lastUpdate=millis();
	         }
	 }
	}  
	
	void updateValues(){
		  SharedPreferences settings = getSharedPreferences(getString(R.string.prefsFile), 0);        
		  words.set(0, settings.getString(getString(R.string.name), getString(R.string.defaultName)));
		  words.set(1, settings.getString(getString(R.string.surname1), getString(R.string.defaultSurname1)));
		  words.set(2, settings.getString(getString(R.string.surname2), getString(R.string.defaultSurname2)));	
		  
	}
	
	
}

