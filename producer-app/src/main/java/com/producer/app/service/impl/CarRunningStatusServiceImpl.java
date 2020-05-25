package com.producer.app.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producer.app.dto.CarRunningStatusDTO;
import com.producer.app.service.CarRunningStatusService;
import com.producer.app.service.Sender;

@Service
public class CarRunningStatusServiceImpl implements CarRunningStatusService {

	//@Autowired
	//private ModelMapper modelMapper;
	Random rand = new Random();
	@Autowired
	private Sender sender;
	
	

	@Override
	@Transactional
	public void sendCarRunningInfo(List<CarRunningStatusDTO> carRunningStatusDTOList) {

	

		// nextInt as provided by Random is exclusive of the top value so you need to add 1 

		
		int c=1;
		List<Integer> latlong=new ArrayList<>();
		 
		for(int i=5;i<=10;i++) {
			try {
			int ramdomNum=generateRandom(i,c);
			int ramdomNum2=generateRandom(i+1,c);
			
			latlong.add(ramdomNum);
			latlong.add(ramdomNum2);		
			 sender.send( new CarRunningStatusDTO("",latlong,LocalDateTime.now()));
			// carRunningStatusDTOList.forEach(carRunningStatusDTO -> sender.send(carRunningStatusDTO));
			 latlong.removeAll(latlong);
			}
			catch(Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
		
		

	}
	
	public Integer generateRandom(int max,int min) {
		
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
		
		
	}
	
}
