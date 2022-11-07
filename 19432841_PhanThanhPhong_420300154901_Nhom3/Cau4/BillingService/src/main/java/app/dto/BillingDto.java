package app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingDto {
	private String id;
	private String name;
	private double price;
	private PassengerDto passenger;
}
