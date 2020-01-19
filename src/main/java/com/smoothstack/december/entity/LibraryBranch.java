package com.smoothstack.december.entity;

import java.util.Map;

import javax.persistence.*;

@Entity
@Table(name = "tbl_library_branch")
public class LibraryBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    @Column(name = "branchName")
    private String branchName;

    @Column(name = "branchAddress")
    private String branchAddress;

    // TODO: private Map<Integer, Book> books;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public void addBook(Book book) {
    }
}
