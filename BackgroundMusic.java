package com.nutriblast;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.*;
import java.util.Random;

public class BackgroundMusic extends Thread {
	AudioInputStream stream;
	SourceDataLine line;
	Random rand = new Random();
	private static final String MUSIC_FILE = "PLACEHOLDER.wav";

	public synchronized void playSound() {
		while (!Thread.interrupted()) {
			try {
				stream = AudioSystem.getAudioInputStream(new File(MUSIC_FILE));
				AudioFormat format = stream.getFormat();
				if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
					format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
							format.getSampleRate(),
							format.getSampleSizeInBits() * 2,
							format.getChannels(), format.getFrameSize() * 2,
							format.getFrameRate(), true);
					stream = AudioSystem.getAudioInputStream(format, stream);
				}
				// Create line
				SourceDataLine.Info info = new DataLine.Info(
						SourceDataLine.class, stream.getFormat(),
						((int) stream.getFrameLength() * format.getFrameSize()));
				line = (SourceDataLine) AudioSystem.getLine(info);
				line.open(stream.getFormat());
				line.start();
				// Continuously read and play chunks of audio
				int numRead = 0;
				byte[] buf = new byte[line.getBufferSize()];
				while ((numRead = stream.read(buf, 0, buf.length)) >= 0) {
					int offset = 0;
					while (offset < numRead) {
						offset += line.write(buf, offset, numRead - offset);
					}
				}
				line.drain();
				line.stop();

			} catch (IOException e) {
				e.printStackTrace(); //REMOVE
			} catch (LineUnavailableException e) {
				e.printStackTrace(); //REMOVE
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace(); //REMOVE
			}
		}
	}

	public void kill() {
		try {
			line.drain();
			line.stop();
			stream.close();
		} catch (IOException e) {
		}
	}

	public BackgroundMusic() {
	}

	public void run() {
		playSound();
	}
}
