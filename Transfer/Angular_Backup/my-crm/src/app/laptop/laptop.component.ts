import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-laptop',
  templateUrl: './laptop.component.html',
  styleUrls: ['./laptop.component.css']
})
export class LaptopComponent implements OnInit {

  selectedLaptop;

  laptops = [
    {
      name: 'Asus',
      imgUrl: 'https://cdn.pixabay.com/photo/2014/09/27/13/44/notebook-463485__340.jpg',
      details: 'Rs : 53000 ASUS Laptop X407UB. Processor. Intel® Core™ i3 6006U Processor, 2 GHz (3 M Cache) Operating System. Windows 10 Pro - ASUS recommends Windows 10 Pro. Memory. DDR4 2400MHz SDRAM, 1 x SO-DIMM socket , up to 8 GB SDRAM. Display. 14.0" (16:9) LED-backlit HD (1366x768) 60Hz Anti-Glare Panel with 45% NTSC. Graphic Storage.'
    },
    {
      name: 'HP',
      imgUrl: 'https://cdn.pixabay.com/photo/2015/07/26/17/29/mixer-861431__340.jpg',
      details: 'Rs : 40000 HP Pavilion x360 With Alexa In-built. Freedom To Do More w/ Power Of Your Voice. Shop Now! Accidental Protection. Protegent Antivirus. Additional Warranty. Theft Insurance. Models: HP Pavilion x360 14, HP Gaming Pavilion - 15, OMEN by HP 15, HP Notebook - 15.'
    },
    {
      name: 'Dell',
      imgUrl: 'https://cdn.pixabay.com/photo/2017/08/10/07/32/dell-2619501__340.jpg',
      details: 'Rs : 34000 Dell 15 7000 Crafted From Brushed Aluminium. Laptop W/ Intel Core. Shop Today! Sennheiser Headset @ 299. Get 3Yr Premium Support. Cash off on MS Office. Get Warranty Worth@₹3999. Amenities: Dell Power Companion, Dell Bluetooth Mouse.'
    } ,
    {
      name: 'Apple',
      imgUrl: 'https://cdn.pixabay.com/photo/2014/05/02/21/49/home-office-336373__340.jpg',
      details: 'Rs : 59999 2.4GHz 8-core Intel Core i9, Turbo Boost up to 5.0GHz, with 16MB shared L3 cache. 32GB of 2400MHz DDR4 memory. Radeon Pro 560X with 4GB of GDDR5 memory. 2.4GHz 8-core Intel Core i9, Turbo Boost up to 5.0GHz, with 16MB shared L3 cache. 32GB of 2400MHz DDR4 memory. Radeon Pro 560X with 4GB of GDDR5 memory.'
    }
  ];
  constructor() { }

  selectLaptop(laptop) {
    this.selectedLaptop = laptop;
  }

  ngOnInit() {
  }

}
