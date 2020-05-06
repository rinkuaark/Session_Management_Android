package com.honeydhiman.session_management_android;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement  {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SESSION_PREF_NAME="session";
    String SESSION_KEY="session-user";

    public SessionManagement(Context context)
    {
       sharedPreferences=context.getSharedPreferences(SESSION_PREF_NAME,Context.MODE_PRIVATE);
       editor=sharedPreferences.edit();
    }



    public  void saveSession(User user)
    {
        ///here User is model that is created
        ///save the session of user whenever user is logged in
        int id=user.getId();
        editor.putInt(SESSION_KEY,id).commit();
    }

    public int getSession()
    {
        //return user whose session is saved
        return sharedPreferences.getInt(SESSION_KEY,-1);
    }

    public void removeSession()
    {
        //when user click on log out the session remove
        editor.putInt(SESSION_KEY,-1).commit();
    }

}
