package android.example.holidays.Data.Entities;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Holidays
{
    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("date")
    private Date date;

    @SerializedName("type")
    private List<String> type;

    @SerializedName("locations")
    private String locations;

    private List<States> statesList;

    public void setStatess(List<States> states_value){
        statesList = states_value;
    }

    public class States
    {
        private int id;

        private String abbrev;

        private String name;

        private String exception;

        private String iso;


        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setAbbrev(String abbrev){
            this.abbrev = abbrev;
        }
        public String getAbbrev(){
            return this.abbrev;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void setException(String exception){
            this.exception = exception;
        }
        public String getException(){
            return this.exception;
        }
        public void setIso(String iso){
            this.iso = iso;
        }
        public String getIso(){
            return this.iso;
        }
    }


    public static class HolidaysDeserilizer implements JsonDeserializer<Holidays> {

        @Override
        public Holidays  deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            Holidays holidays = new Gson().fromJson(json, Holidays.class);
            JsonObject jsonObject = json.getAsJsonObject();

            if (jsonObject.has("states")) {
                JsonElement elem = jsonObject.get("states");
                if (elem != null && !elem.isJsonNull()) {
                    String valuesString = elem.toString();
                    Log.e("fd","" + valuesString);
                    if (!valuesString.equals("\"All\"")) {
                        List<States> values = new Gson().fromJson(valuesString, new TypeToken<ArrayList<States>>()
                        {}.getType());
                        holidays.setStatess(values);
                    }
                }
            }
            return holidays;
        }
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return this.date;
    }
    public void setType(List<String> type){
        this.type = type;
    }
    public List<String> getType(){
        return this.type;
    }
    public void setLocations(String locations){
        this.locations = locations;
    }
    public String getLocations(){
        return this.locations;
    }
    public void setStates(List<States> states){
        this.statesList = states;
    }
    public List<States> getStates(){
        return this.statesList;
    }
}

