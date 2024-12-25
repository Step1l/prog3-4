import java.util.ArrayList;

interface GiftRes{
     void prepareResources(Resource resource, int count);
     ArrayList<Resource> provideResources(int enough_count) throws NotEnoughException;
}