import java.util.ArrayList;

interface GiftRes{
    public void prepareResources(Resource resource, int count);
    public ArrayList<Resource> provideResources(int enough_count);
}