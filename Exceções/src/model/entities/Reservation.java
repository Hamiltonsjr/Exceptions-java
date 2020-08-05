package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){

    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        if(!checkOut.after(checkIn)){
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

     // Método para calcular os dias de Hospedagem
    // convertendo milissegundo em dias.

    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS );
    }

    /*public void updateDate(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new IllegalArgumentException("Error in reservation: Reservation dates for update must be future");
        }
        if (!checkOut.after(checkIn)) {
            throw new IllegalArgumentException("Error in reservation: Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }*/

    // Com a Exceção personalizada.

    public void updateDate(Date checkIn, Date checkOut) {
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("Error in reservation: Reservation dates for update must be future");
        }
        if(!checkOut.after(now) || getCheckOut().before(now)){
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");

        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    @Override
    public String toString(){
        return  "Room "
                + roomNumber
                + " - Check-in "
                + simpleDateFormat.format(checkIn)
                + " - Check-out "
                + simpleDateFormat.format(checkOut)
                + " - "
                + duration()
                + " nights";
    }
}
