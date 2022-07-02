package com.lagnus.nasa.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class asteroids {
	
	private @Getter @Setter String 	name;
	private @Getter @Setter long 	diameter;
	private @Getter @Setter int 	speedH;
	//private @Getter @Setter Date 	date;
	private @Getter @Setter String 	planet;
	
	
	
	

}
