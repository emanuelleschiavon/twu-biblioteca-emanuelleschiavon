//package com.twu.biblioteca.controller;
//
//import com.twu.biblioteca.ui.Menu;
//
//public class EvaluatorMenu {
//
//    private Menu;
//
//    public void evaluateOption(Integer optionMenu) {
//        Library library = new Library();
//        Integer bookId;
//        switch (optionMenu) {
//            case 0:
//                System.exit(0);
//            case 1:
//                userInterface.printBooks(library.listAvailableItems());
//                break;
//            case 2:
//                userInterface.printCheckOut();
//                bookId = userInterface.readNumber();
//                Boolean checkOutItem = checkOutItem(bookId, library);
//                if(checkOutItem){
//                    userInterface.printMessageCheckOutSuccess();
//                }else{
//                    userInterface.printMessageCheckOutNotSuccess();
//                }
//                break;
//            case 3:
//                userInterface.printGiveBack();
//                bookId = userInterface.readNumber();
//                Boolean giveBackBook = giveBackBook(bookId, library);
//                if (giveBackBook){
//                    userInterface.printMessageGiveBackSuccess();
//                }else{
//                    userInterface.printMessageGiveBackNotSuccess();
//                }
//                break;
//            default:
//                userInterface.printMessageError();
//                break;
//        }
//    }
//
//    private Boolean checkOutItem(Integer bookId, Library library) {
//        try {
//            Boolean checkOutBookWithSuccess = library.checkOutItem(bookId);
//            return checkOutBookWithSuccess;
//        } catch (ItemNotFoundException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
//
//    private Boolean giveBackBook(Integer bookId, Library library) {
//        try {
//            Boolean giveBackBookWithSuccess = library.giveBackBook(bookId);
//            return giveBackBookWithSuccess;
//        } catch (ItemNotFoundException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
//
//
//}
