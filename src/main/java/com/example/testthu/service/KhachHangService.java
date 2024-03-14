package com.example.testthu.service;

import com.example.testthu.model.KhachHang;
import com.example.testthu.repository.KhachHangRepository;

import java.util.List;

public class KhachHangService {
    public KhachHangRepository khachHangRepository = new KhachHangRepository();
    public List<KhachHang> getAll(){
        return khachHangRepository.getAll();
    }
    public KhachHang getOne(String id){
        return khachHangRepository.getOne(id);
    }
    public Boolean add(KhachHang kh){
        return khachHangRepository.add(kh);
    }
    public Boolean delete(KhachHang kh){
        return khachHangRepository.delete(kh);
    }
    public Boolean update(KhachHang kh){
        return khachHangRepository.update(kh);
    }

}
