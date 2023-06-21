package cn.itcast.druid;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * author:Administrator
 * createTime:2023/4/1519:06
 */
public class emp {
    private Integer id;
    private String ename;
    private Integer job_id;
    private Integer mgr;
    private Date joindate;
    private BigDecimal salary;
    private BigDecimal bonus;
    private Integer dept_id;

    public emp(int id, String ename, int jobId, int mgr, java.sql.Date joindate, double salary, double bonus, int deptId) {
    }

    public emp(int id, String ename, int job_id, int mgr, Date joindate, BigDecimal salary, BigDecimal bonus, int dept_id) {
        this.id = id;
        this.ename = ename;
        this.job_id = job_id;
        this.mgr = mgr;
        this.joindate = joindate;
        this.salary = salary;
        this.bonus = bonus;
        this.dept_id = dept_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof emp)) return false;
        emp emp = (emp) o;
        return getId() == emp.getId() && getJob_id() == emp.getJob_id() && getMgr() == emp.getMgr() && getDept_id() == emp.getDept_id() && Objects.equals(getEname(), emp.getEname()) && Objects.equals(getJoindate(), emp.getJoindate()) && Objects.equals(getSalary(), emp.getSalary()) && Objects.equals(getBonus(), emp.getBonus());
    }

    @Override

    public int hashCode() {
        return Objects.hash(getId(), getEname(), getJob_id(), getMgr(), getJoindate(), getSalary(), getBonus(), getDept_id());
    }


    @Override
    public String toString() {
        return "emp{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", job_id=" + job_id +
                ", mgr=" + mgr +
                ", joindate=" + joindate +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", dept_id=" + dept_id +
                '}';
    }
}
