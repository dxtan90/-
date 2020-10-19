package com.text.springboot.bean;

public class Armsperson {
    private Integer ryid;

    private String ryname;

    private String sex;

    private String nationaloty;

    private String birth;

    private String title;

    private String rank;

    private String politicalParty;

    private String cultureLevel;

    private String maritalCondition;

    private String familyPlace;

    private String idCard;

    private Integer depId;

    private String position;

    private String upperid;

    private String photo;

    public Integer getRyid() {
        return ryid;
    }

    public void setRyid(Integer ryid) {
        this.ryid = ryid;
    }

    public String getRyname() {
        return ryname;
    }

    public void setRyname(String ryname) {
        this.ryname = ryname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationaloty() {
        return nationaloty;
    }

    public void setNationaloty(String nationaloty) {
        this.nationaloty = nationaloty;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(String politicalParty) {
        this.politicalParty = politicalParty;
    }

    public String getCultureLevel() {
        return cultureLevel;
    }

    public void setCultureLevel(String cultureLevel) {
        this.cultureLevel = cultureLevel;
    }

    public String getMaritalCondition() {
        return maritalCondition;
    }

    public void setMaritalCondition(String maritalCondition) {
        this.maritalCondition = maritalCondition;
    }

    public String getFamilyPlace() {
        return familyPlace;
    }

    public void setFamilyPlace(String familyPlace) {
        this.familyPlace = familyPlace;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUpperid() {
        return upperid;
    }

    public void setUpperid(String upperid) {
        this.upperid = upperid;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ryid=").append(ryid);
        sb.append(", ryname=").append(ryname);
        sb.append(", sex=").append(sex);
        sb.append(", nationaloty=").append(nationaloty);
        sb.append(", birth=").append(birth);
        sb.append(", title=").append(title);
        sb.append(", rank=").append(rank);
        sb.append(", politicalParty=").append(politicalParty);
        sb.append(", cultureLevel=").append(cultureLevel);
        sb.append(", maritalCondition=").append(maritalCondition);
        sb.append(", familyPlace=").append(familyPlace);
        sb.append(", idCard=").append(idCard);
        sb.append(", depId=").append(depId);
        sb.append(", position=").append(position);
        sb.append(", upperid=").append(upperid);
        sb.append(", photo=").append(photo);
        sb.append("]");
        return sb.toString();
    }
}