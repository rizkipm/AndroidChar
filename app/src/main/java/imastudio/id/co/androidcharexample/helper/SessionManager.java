package imastudio.id.co.androidcharexample.helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;

import superheroku.id.co.kolakaapps.MainActivity;


public class SessionManager extends MyFuction {
    @VisibleForTesting

    /*variable sharepreference*/
            SharedPreferences pref;

    private static final String KEY_TOKEN = "tokenLogin";

    public SharedPreferences.Editor editor;
    public SessionManager sessionManager;

    /*mode share preference*/
    int mode = 0;

    /*nama dari share preference*/
    private static final String pref_name = "crudpref";

    /*kunci share preference*/
    private static final String is_login = "isLogin";
    public static final String kunci_email = "keyemail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_main);
        sessionManager = new SessionManager(getApplicationContext());
     //   setTheme(R.style.MyAppTheme);

    }
    public SessionManager(){

    }

    /*construktor*/
    public SessionManager(Context context) {
        /*mengakses class ini*/
        c = context;
        /*share preference dari class ini*/ /*(nama, mode)*/
        pref = context.getSharedPreferences(pref_name, mode);
        editor = pref.edit();
    }

    /*methode membuat session*/
    public void createSession(String email){
        /*login value menjadi true*/
        editor.putBoolean(is_login, true);
        /*memasukkan email ke dalam variable kunci email*/
        editor.putString(kunci_email, email);
        editor.commit();
    }



    public void checkLogin(){
        /*jika is_login = false*/
        if (!this.islogin()){
            /*pergi ke loginactivity*/

            Intent i = new Intent(c, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                c.startActivity(i);
                finish();
//            String a1 = sessionManager.getIdAkses();
//            if (a1.equalsIgnoreCase("1")){
//                Intent i = new Intent(c, MenuBeforeLogin.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                c.startActivity(i);
//                finish();
//            }else if (a1.equalsIgnoreCase("2")){
//                Intent i = new Intent(c, MenuUtamaBuyer.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                c.startActivity(i);
//                finish();
//            }

        }else {
            /*jika true, pergi ke mainactivity*/

//            String a1 = sessionManager.getIdAkses();
//            if (a1.equalsIgnoreCase("1")){
//                Intent i = new Intent(c, MenuUserAfterLogin.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                c.startActivity(i);
//                finish();
//            }else if (a1.equalsIgnoreCase("2")){
//                Intent i = new Intent(c, MenuUtamaBuyer.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                c.startActivity(i);
//                finish();
//            }
            Intent i = new Intent(c, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.startActivity(i);
            finish();
        }
    }

    /*set is_login menjadi false*/
    public boolean islogin() {
        return pref.getBoolean(is_login, false);
    }





    public void logout(){

        /*hapus semua data dan kunci*/
        editor.clear();
        editor.commit();

        //gmail logout


        /*pergi ke loginactivity*/
        Intent i = new Intent(c, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        c.startActivity(i);
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }

    public  String password, address, id_akses, email_user,pekerjaan,tgl_create, last_name,hp_user,id_user,first_name ;


    public String getPassword() {
        return pref.getString("password", "");
    }

    public void setPassword(String password) {
        editor.putString("password", password);
        editor.commit();
    }

    public String getPekerjaan() {
        return pref.getString("pekerjaan", "");
    }

    public void setPekerjaan(String pekerjaan) {
        editor.putString("pekerjaan", pekerjaan);
        editor.commit();
    }
//
    public String getTgl_create() {
        return pref.getString("tgl_create", "");
    }

    public void setTgl_create(String tgl_create) {
        editor.putString("tgl_create", tgl_create);
        editor.commit();
    }
//
    public String getLast_name() {
        return pref.getString("last_name", "");
    }

    public void setLast_name(String last_name) {
        editor.putString("last_name", last_name);
        editor.commit();
    }
//
    public void setFirst_name(String first_name){
        editor.putString("first_name", first_name);
        editor.commit();
    }
    public String getFirst_name(){
        return pref.getString("first_name", "");
    }
//
    public void setIdAkses(String id_akses){
        editor.putString("id_akses", id_akses);
        editor.commit();
    }
    public String getIdAkses(){
        return pref.getString("id_akses", "");
    }
    public void setEmail(String email){
        editor.putString("email_user", email);
        editor.commit();
    }
    public String getEmail(){
        return pref.getString("email_user", "");
    }
    public void setPhone(String phone){
        editor.putString("hp_user", phone);
        editor.commit();
    }


    public String getPhone(){
        return pref.getString("hp_user", "");
    }
    public void setAlamat(String user_alamat){
        editor.putString("address", user_alamat);
        editor.commit();
    }
    public String getAlamat(){
        return pref.getString("address", "");
    }
    public void setIdUser(String iduser) {
        editor.putBoolean(is_login, true);
        editor.putString("id_user", iduser);
        editor.commit();
    }

    public String getIdUser() {
        return pref.getString("id_user", "");
    }

//
//    public void setGcm(String gcm){
//        editor.putString("gcm", gcm);
//        editor.commit();
//    }
//
//    public void setUserTenant(String user_tenant){
//        editor.putString("user_tenant", user_tenant);
//        editor.commit();
//    }
//    public String getUserTenant(){
//        return pref.getString("user_tenant", "");
//    }
//
//    public String getGcm(){
//        return pref.getString("gcm", "");
//    }

    //mendapatkan token
    public String getToken(){
        return pref.getString(KEY_TOKEN, "");
    }


}
