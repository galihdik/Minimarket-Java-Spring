package com.lawencon.minimarket.view;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.lawencon.minimarket.model.Profiles;
import com.lawencon.minimarket.service.ProfileService;
import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class ProfileView {
	private ProfileService profileServices;
	private List<Profiles> profile;
	private Profiles prf = new Profiles();
	private Scanner input = new Scanner(System.in);

	public ProfileView(ProfileService profileServices) {
		this.profileServices = profileServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Profile ====");
		System.out.println("1. Create Profile");
		System.out.println("2. Read Profile");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");
		Scanner input = new Scanner(System.in);
		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addProfile();
			show(cb);
		} else if (pilih == 2) {
			try {
				profile = profileServices.getProfile();
				System.out.println("Id Profile  | Address Profile | Name Profile");
				profile.forEach(prf -> {
					System.out.printf("|%-8s|%-10s|%-10s\n", prf.getIdProfiles(), prf.getNameProfile(),
							prf.getAddressProfile());

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

	void addProfile() {
		System.out.println("Masukan Nama : ");
		String nama = input.next();
		System.out.println("Masukan address : ");
		String address = input.next();
		nama.toLowerCase();
		Random random = new Random();
		int tampungRandom = random.nextInt(999);
		String tampungCode = "spl" + tampungRandom;
		prf.setAddressProfile(address);
		prf.setNameProfile(nama);
		prf.setProfileCode(tampungCode);
		try {
			profileServices.addData(prf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
