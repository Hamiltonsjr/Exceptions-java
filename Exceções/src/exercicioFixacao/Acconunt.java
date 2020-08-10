package exercicioFixacao;

public class Acconunt {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;

    public Acconunt(){

    }

    public Acconunt(Integer number, String holder, Double balance, Double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(Double withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;

    }
    // Se o saque for maior que o limite de saque ou saque for maior que o saldo
    // Exceção personalizada

    public void withdraw(Double amount){
        if(amount > withDrawLimit){
            throw new DomainException("The amount exceeds withdrawn limit.");
        }
        if(amount > balance){
            throw new DomainException("Not enough balance");

        }
        balance -= amount;
    }
}
