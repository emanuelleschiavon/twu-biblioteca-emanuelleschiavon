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
//                userInterface.printBooks(library.listBooksAvailable());
//                break;
//            case 2:
//                userInterface.printCheckOut();
//                bookId = userInterface.readNumber();
//                Boolean checkOutBook = checkOutBook(bookId, library);
//                if(checkOutBook){
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
//    private Boolean checkOutBook(Integer bookId, Library library) {
//        try {
//            Boolean checkOutBookWithSuccess = library.checkOutBook(bookId);
//            return checkOutBookWithSuccess;
//        } catch (BookNotFoundException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
//
//    private Boolean giveBackBook(Integer bookId, Library library) {
//        try {
//            Boolean giveBackBookWithSuccess = library.giveBackBook(bookId);
//            return giveBackBookWithSuccess;
//        } catch (BookNotFoundException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
//
//
//}
