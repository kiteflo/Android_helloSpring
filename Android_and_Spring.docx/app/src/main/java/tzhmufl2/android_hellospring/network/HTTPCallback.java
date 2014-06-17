package tzhmufl2.android_hellospring.network;

import tzhmufl2.android_hellospring.domain.DTOCharacterResponseList;

/**
 * Created by tzhmufl2 on 15.06.14.
 */
public interface HTTPCallback
{
    public void postExecute(DTOCharacterResponseList result);
    public void preExecute();
}
