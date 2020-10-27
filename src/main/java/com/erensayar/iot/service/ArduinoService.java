package com.erensayar.iot.service;

import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.springframework.stereotype.Service;

/**
 *
 * @author ErenSayar
 */
@Service
public class ArduinoService implements IArduinoService {

    // Arduinoya yüklenen firmata yazılımı ile kontrol bağlantı sağlar ve led yakar.
    @Override
    public void ledOn() {
        IODevice device = new FirmataDevice("COM5"); // using the name of a port
        try {
            device.start(); // initiate communication to the device
            device.ensureInitializationIsDone(); // wait for initialization is done
            Pin pin = device.getPin(13);
            pin.setMode(Pin.Mode.OUTPUT); // our listeners will get event about this change
            pin.setValue(1); // and then about this change
            device.stop(); // stop communication to the device
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Arduinoya yüklenen firmata yazılımı ile kontrol bağlantı sağlar ve ledi söndürür.
    @Override
    public void ledOff() {
        IODevice device = new FirmataDevice("COM5"); // using the name of a port
        try {
            device.start(); // initiate communication to the device
            device.ensureInitializationIsDone(); // wait for initialization is done
            Pin pin = device.getPin(13);
            pin.setMode(Pin.Mode.OUTPUT); // our listeners will get event about this change
            pin.setValue(0); // and then about this change
            device.stop(); // stop communication to the device
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
