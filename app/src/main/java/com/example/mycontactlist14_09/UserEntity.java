package com.example.mycontactlist14_09;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "users")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "emailId")
    String emailId;

    @ColumnInfo(name = "Password")
    String password;

    @ColumnInfo(name = "ConfirmPassword")
    String ConfirmPassword;

    @ColumnInfo(name = "firstName")
    private String first_name;

    @ColumnInfo(name = "lastName")
    private String last_name;

    @ColumnInfo(name = "Email")
    private String email;

    @ColumnInfo(name = "Phn")
    private String phn;

    public UserEntity(String first_name, String last_name, String email, String  phn) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phn = phn;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public UserEntity() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public static DiffUtil.ItemCallback<UserEntity> DIFF_CALLBACK = new DiffUtil.ItemCallback<UserEntity>() {
        @Override
        public boolean areItemsTheSame(@NonNull UserEntity oldItem, @NonNull UserEntity newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull UserEntity oldItem, @NonNull UserEntity newItem) {
            return oldItem.equals(newItem);
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getEmailId(), that.getEmailId()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getConfirmPassword(), that.getConfirmPassword()) &&
                Objects.equals(getFirst_name(), that.getFirst_name()) &&
                Objects.equals(getLast_name(), that.getLast_name()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPhn(), that.getPhn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmailId(), getPassword(), getConfirmPassword(), getFirst_name(), getLast_name(), getEmail(), getPhn());
    }
}
