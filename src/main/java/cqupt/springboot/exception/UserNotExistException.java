package cqupt.springboot.exception;

/**
 * @author Liyi
 * @create 2020-04-21 9:32
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
//    private static final long serialVersionUID = 1L;
//    private String id;
//
//    public UserNotExistException(String id) {
//        super("user not exist");
//        this.id = id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getId() {
//        return id;
//    }

}
