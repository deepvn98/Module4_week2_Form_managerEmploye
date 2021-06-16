package model;

import org.springframework.web.multipart.MultipartFile;

public class EmployeFileUpload {
    private int id;
    private String name;
    private MultipartFile img;
    private String phone;

    public EmployeFileUpload() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeFileUpload(String name, MultipartFile img, String phone) {
        this.name = name;
        this.img = img;
        this.phone = phone;
    }

    public EmployeFileUpload(int id, String name, MultipartFile img, String phone) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.phone = phone;
    }
}
