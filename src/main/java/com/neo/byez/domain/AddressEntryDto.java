package com.neo.byez.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Objects;

public class AddressEntryDto {

    String id;
    int seq;
    @NotNull(message = "수령인을 입력해주세요.")
    private String recipient;

    @NotNull(message = "닉네임을 입력해주세요.")
    private String nick;

    @Pattern(regexp="[0-9]{5}", message="우편번호는 5자리 숫자여야 합니다.")
    private String zpcd;

    @NotNull(message = "주소를 입력해주세요.")
    private String mainAddr;

    @NotNull(message = "상세주소를 입력해주세요.")
    private String detailAddr;

    @Pattern(regexp="^(|\\d{2,3}\\d{3,4}\\d{4})$", message="올바른 전화번호 형식이 아닙니다. (숫자만 입력)")
    private String telNum;

    @Pattern(regexp="^01(?:0|1|[6-9])\\d{3,4}\\d{4}$", message="올바른 휴대전화 번호 형식이 아닙니다. (숫자만 입력)")
    @NotNull(message = "휴대전화 번호를 입력해주세요.")
    private String mobileNum;
    Date addrRegDate;
    Date regDate;
    String regId;
    Date upDate;
    String upId;

    public AddressEntryDto() {}

    public AddressEntryDto(String id, String recipient, String nick, String zpcd, String mainAddr, String detailAddr, String telNum, String mobileNum) {
        this.id = id;
        this.recipient = recipient;
        this.nick = nick;
        this.zpcd = zpcd;
        this.mainAddr = mainAddr;
        this.detailAddr = detailAddr;
        this.telNum = telNum;
        this.mobileNum = mobileNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntryDto that = (AddressEntryDto) o;
        return Objects.equals(recipient, that.recipient) && Objects.equals(nick, that.nick) && Objects.equals(zpcd, that.zpcd) && Objects.equals(mainAddr, that.mainAddr) && Objects.equals(detailAddr, that.detailAddr) && Objects.equals(mobileNum, that.mobileNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient, nick, zpcd, mainAddr, detailAddr, mobileNum);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = (recipient != null && !recipient.isEmpty()) ? recipient : null;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = (nick != null && !nick.isEmpty()) ? nick : null;
    }

    public String getZpcd() {
        return zpcd;
    }

    public void setZpcd(String zpcd) {
        this.zpcd = (zpcd != null && !zpcd.isEmpty()) ? zpcd : null;
    }

    public String getMainAddr() {
        return mainAddr;
    }

    public void setMainAddr(String mainAddr) {
        this.mainAddr = (mainAddr != null && !mainAddr.isEmpty()) ? mainAddr : null;
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = (detailAddr != null && !detailAddr.isEmpty()) ? detailAddr : null;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = (telNum != null && !telNum.isEmpty()) ? telNum : null;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = (mobileNum != null && !mobileNum.isEmpty()) ? mobileNum : null;
    }
    public Date getAddrRegDate() {
        return addrRegDate;
    }

    public void setAddrRegDate(Date addrRegDate) {
        this.addrRegDate = addrRegDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public String getUpId() {
        return upId;
    }

    public void setUpId(String upId) {
        this.upId = upId;
    }

    @Override
    public String toString() {
        return "AddrListDto{" +
                "id=" + id +
                ", seq=" + seq +
                ", recipient='" + recipient + '\'' +
                ", nick='" + nick + '\'' +
                ", zpcd=" + zpcd +
                ", mainAddr='" + mainAddr + '\'' +
                ", detailAddr='" + detailAddr + '\'' +
                ", telNum='" + telNum + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", addrRegDate=" + addrRegDate +
                ", regDate=" + regDate +
                ", reg_id='" + regId + '\'' +
                ", upDate=" + upDate +
                ", upId='" + upId + '\'' +
                '}';
    }
}