package surya.automation.utils;


public class Enums {
    public enum Status {
        pending,
        confirmed
    }

    public enum BookingType {
        Hotel("la-hotel"),
        Flight("la-plane");

        public final String bookingType;
        private BookingType(String bookingType) {
            this.bookingType = bookingType;
        }
        public String getBookingType() {
            return this.bookingType;
        }
    }
}



