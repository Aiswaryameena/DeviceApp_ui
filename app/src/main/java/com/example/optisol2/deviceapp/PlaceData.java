package com.example.optisol2.deviceapp;

import java.util.ArrayList;

public class PlaceData {

  public static String[] placeNameArray = {"Bora Bora", "Canada", "Dubai", "Hong Kong", "Iceland", "India", "Kenya", "London", "Switzerland", "Sydney"};
  public static  String[] placevalue={" island in the Leeward group in the western part of the Society Islands of French Polynesia, an overseas collectivity of France in the Pacific Ocean","is a country in the northern half of North America. Its ten provinces and three territories extend from the Atlantic to the Pacific and northward into the Arctic Ocean",
          "It is located on the southeast coast of the Arabic Gulf and is the capital of the Emirate of Dubai, one of the seven emirates that make up the country","is an autonomous territory on the Pearl River Delta of East Asia.[16] Macau lies across the delta to the west, and the Chinese province of Guangdong borders the territory to the north",
  "is a Nordic island country in the North Atlantic Ocean. It has a population of 332,529 and an area of 103,000 km"," It is the seventh-largest country by area, the second-most populous country",
  "is a country in Africa and a founding member of the East African Community (EAC). Its capital and largest city is Nairobi","is the capital and most populous city of England and the United Kingdom",
  "is a federal republic in Europe. It consists of 26 cantons, and the city of Bern is the seat of the federal authorities"," is the state capital of New South Wales and the most populous city in Australia and Oceania"};
  public static Integer[] placeimage1={R.drawable.borabora,R.drawable.canada,R.drawable.dubai,R.drawable.hongkong,R.drawable.iceland,R.drawable.india,R.drawable.kenya,R.drawable.london,R.drawable.switzerland,R.drawable.sydney};
  public static ArrayList<Place> placeList() {
    ArrayList<Place> list = new ArrayList<>();
    for (int i = 0; i < placeNameArray.length; i++) {
      Place place = new Place();
      place.name = placeNameArray[i];
      place.imageName = placeNameArray[i].replaceAll("\\s+", "").toLowerCase();
      place.img=placeimage1[i];
        place.placevalue=placevalue[i];
      if (i == 2 || i == 5) {
        place.isFav = true;
      }
      list.add(place);
    }
    return (list);
  }
}
