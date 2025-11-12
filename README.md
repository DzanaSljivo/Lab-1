# 📸 Photo Gallery – Mini Java Projekt

Ovaj projekat je izrađen u okviru vježbi iz **Programiranja u Javi** (3. godina, Softversko inženjerstvo – Politehnički fakultet Univerziteta u Zenici).  
👩‍💻 Autori: **Džana Šljivo** i **Amina Goralija**

Tema projekta je jednostavna aplikacija za organizaciju i pregled fotografija po albumima.

---

## 🧩 Opis projekta

Aplikacija **Photo Gallery** simulira osnovni sistem galerije fotografija.  
Korisnik može kreirati albume, dodavati fotografije u njih, pregledati postojeće slike i njihove podatke te jednostavno upravljati sadržajem galerije.

Svaka fotografija ima svoje osnovne atribute (npr. naziv, opis, datum, veličina, putanja), dok svaki album sadrži kolekciju više fotografija.  
Svi podaci se čuvaju u memoriji tokom rada aplikacije pomoću Java kolekcija (`ArrayList`), bez upotrebe baze podataka.

---

## 🧱 Struktura projekta

photo_gallery/
├─ src/main/java/
│ ├─ model/
│ │ ├─ Album.java # Klasa koja predstavlja jedan album (naziv, lista fotografija)
│ │ └─ Photo.java # Klasa koja predstavlja jednu fotografiju (naziv, opis, datum, putanja)
│ └─ PhotoGalleryApp.java # Glavna klasa aplikacije (main metoda – ulazna tačka)
│
├─ pom.xml # Maven konfiguracija projekta
├─ .gitignore # Git konfiguracija
└─ .idea/ # Postavke IntelliJ okruženja

---

## ⚙️ Objašnjenje logike

- **`Photo`** – predstavlja jednu fotografiju sa atributima kao što su naziv, opis, datum snimanja i putanja do slike.  
- **`Album`** – sadrži naziv albuma i listu fotografija (`ArrayList<Photo>`).  
  Omogućava dodavanje, brisanje i prikaz svih fotografija u datom albumu.  
- **`PhotoGalleryApp`** – glavna klasa s `main()` metodom, u kojoj se instanciraju albumi i fotografije, te demonstrira rad aplikacije kroz tekstualni interfejs ili test primjere.

---

## 🖼️ Glavne funkcionalnosti

- 📁 Kreiranje i pregled svih **albuma**  
- 🖼️ Dodavanje novih **fotografija** u odabrani album  
- 🔍 Pregled svih slika u albumu (naziv, opis, datum)  
- ❌ Brisanje fotografija iz albuma  
- 🧮 Evidencija ukupnog broja albuma i fotografija  
- 💾 Čuvanje podataka u memoriji pomoću Java kolekcija  

---

## 🌱 Kako pokrenuti projekat

1. Otvori projekat u **IntelliJ IDEA** ili drugom Java okruženju.  
2. Uvjeri se da je instaliran **JDK 17+**.  
3. Pokreni glavnu klasu:  
4. Program će se izvršiti u konzoli i prikazati funkcionalnosti galerije.

---

## 🔮 Moguća buduća unapređenja

| Unapređenje | Opis |
|--------------|------|
| Dodavanje GUI interfejsa (JavaFX/Swing) | Omogućiti vizuelno upravljanje slikama i albumima |
| Spremanje podataka u datoteku ili bazu | Umjesto čuvanja u memoriji, podaci bi se trajno snimali |
| Pretraga i sortiranje | Dodati pretragu po nazivu, datumu ili veličini slike |
| Upload i pregled stvarnih slika | Omogućiti učitavanje i prikaz slika sa računara |

---

## 🧠 Cilj vježbe

Projekat **Photo Gallery** pomaže studentima da:  
- razumiju **objektno-orijentisano programiranje (OOP)** u Javi,  
- koriste **klase, atribute, metode i kolekcije** za modeliranje stvarnih entiteta,  
- nauče osnovnu strukturu i organizaciju **Maven** projekta,  
- pripreme se za kasnije projekte sa bazama podataka i grafičkim interfejsima.  

---

🎓 *Politehnički fakultet, Univerzitet u Zenici*  
📅 Akademska godina: **2025/2026**
