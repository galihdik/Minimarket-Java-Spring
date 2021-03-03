package com.lawencon.minimarket.view;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.lawencon.minimarket.model.Supliers;
import com.lawencon.minimarket.service.SupliersService;
import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class SuplierView {
	private SupliersService suplierServices;
	private List<Supliers> suplier;
	private Supliers spl = new Supliers();
	private Scanner input = new Scanner(System.in);

	public SuplierView(SupliersService suplierServices) {
		this.suplierServices = suplierServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Suplier ====");
		System.out.println("1. Create Suplier");
		System.out.println("2. Read Suplier");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");
		Scanner input = new Scanner(System.in);
		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addSuplier();
			show(cb);
		} else if (pilih == 2) {
			try {
				suplier = suplierServices.getSupliers();
				System.out.println("Id Suplier | Name Suplier | Phone Number | Location Suplier ");
				suplier.forEach(spl -> {
					System.out.printf("|%-8s|%-10s|%-10s|%-10s\n", spl.getIdSupliers(), spl.getNameSupliers(),
							spl.getPhoneNumber(), spl.getLocationSupliers());

				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			show(cb);
		} else if (pilih == 3) {

		} else if (pilih == 4) {
			cb.onDone("");
		}
	}

	void addSuplier() {
		System.out.println("Masukan Nama suplier: ");
		String nama = input.next();
		System.out.println("Masukan Nomer Telepon: ");
		String noHp = input.next();
		System.out.println("Masukan Lokasi suplier: ");
		String lokasi = input.next();
		Random random = new Random();
		int tampungRandom = random.nextInt(999);
		String tampungCode = "spl" + tampungRandom;
		spl.setNameSupliers(nama);
		spl.setPhoneNumber(noHp);
		spl.setLocationSupliers(lokasi);
		spl.setSuplierCode(tampungCode);
		try {
			suplierServices.addData(spl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
