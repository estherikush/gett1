package com.example.esthere.gett1.controller;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class DialogEnd {
    public static void Dialog(final Context context, String title, String message, String button){
        AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, button,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(Intent.ACTION_MAIN);
//                        intent.addCategory(Intent.CATEGORY_HOME);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        ((Activity)context).finish();
//                        context.startActivity(intent);
//                        get finish();
//                        System.exit(0);
                        //dialog.dismiss();
//                        Intent myIntent = new Intent(this, MainActivity.class);
//                        startActivity(myIntent);
                        //MainActivity.this.finish();
                    }
                });
        dialog.show();
    }
}



//public class DialogEnd extends DialogFragment {
//
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        // Use the Builder class for convenient dialog construction
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setMessage(R.string.dialog_end)
//                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        quit();
//                        // FIRE ZE MISSILES!
//                    }
//                });
////                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
////                    public void onClick(DialogInterface dialog, int id) {
////                        // User cancelled the dialog
////                    }
////                });
//        // Create the AlertDialog object and return it
//        this.show();
//        return builder.create();
//    }
//    public void quit() {
////        Intent intent = new Intent(Intent.ACTION_MAIN);
////        intent.addCategory(Intent.CATEGORY_HOME);
////        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////        startActivity(intent);
////        finish();
////        System.exit(0);
//
////        Intent startMain = new Intent(Intent.ACTION_MAIN);
////        startMain.addCategory(Intent.CATEGORY_HOME);
////        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////        startMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////        startActivity(startMain);
//    }
//}