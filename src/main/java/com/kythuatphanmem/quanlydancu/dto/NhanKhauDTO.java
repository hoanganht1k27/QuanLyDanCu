package com.kythuatphanmem.quanlydancu.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanKhauDTO {
    @JsonIgnore
    private Long id;
    @JsonProperty("ho_ten")
    private String hoTen;
    @JsonProperty("bi_danh")
    private String biDanh;
    @JsonProperty("cccd")
    private String cccd;
    @JsonIgnore
    private Date ngaySinh;
    @JsonProperty("gioi_tinh")
    private String gioiTinh;
    @JsonProperty("que_quan")
    private String queQuan;
    @JsonProperty("thuong_tru")
    private String thuongTru;
    @JsonProperty("dan_toc")
    private String danToc;
    @JsonProperty("nghe_nghiep")
    private String ngheNghiep;
    @JsonProperty("noi_lam_viec")
    private String noiLamViec;

    @JsonProperty("ngay_sinh")
    public String ngaySinhFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.ngaySinh);
    }
}
