/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author slend
 */
public class UserFriendlyException extends RuntimeException {
    public UserFriendlyException(String message) {
        super(message);
    }
}