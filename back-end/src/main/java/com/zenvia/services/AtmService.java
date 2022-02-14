package com.zenvia.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AtmService {
	
	private Map<Integer, Integer> numberOfBanknotes = new HashMap<Integer, Integer>();
	private int[] bankNotes = {100, 50, 20, 10};
	
	
	public Map<Integer, Integer> withdraw(float value) throws Exception {	
		
		int[] numberOfNotes = {0, 0, 0, 0};
		float amount = value;
		
		if(amount <= 0) {
			throw new Exception("Valor invalido para saque.");
		}
		for(int i = 0; i < bankNotes.length; i++ ) {			
				int notes = (int) Math.floor(amount/bankNotes[i]);
				numberOfNotes[i] = notes;
				amount = amount%bankNotes[i];
				numberOfBanknotes.put(bankNotes[i], numberOfNotes[i]);
				
		}
		if(amount!= 0) {
			throw new Exception("Não temos notas para o valor restante de R$"+ amount);
		}
		return numberOfBanknotes ;
	}	
}
