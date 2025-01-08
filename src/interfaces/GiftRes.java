package interfaces;

import curclasses.Resource;
import exceptions.NotEnoughException;

import java.util.List;

public interface GiftRes{
    public void prepareResources(Resource resource, int count);
    public List<Resource> provideResources(int enoughCount) throws NotEnoughException;
}