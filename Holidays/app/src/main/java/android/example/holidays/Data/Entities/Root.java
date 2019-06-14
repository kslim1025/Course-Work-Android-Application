package android.example.holidays.Data.Entities;

public class Root
{
    private Meta meta;

    private Response response;

    public void setMeta(Meta meta){
        this.meta = meta;
    }
    public Meta getMeta(){
        return this.meta;
    }
    public void setResponse(Response response){
        this.response = response;
    }
    public Response getResponse(){
        return this.response;
    }
}
