package com.lu.wang.snakecharmer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.snakecharmer.data.Node;
import com.lu.wang.snakecharmer.dijkstraalgorithm.DijkstraAlgorithm;
import com.lu.wang.snakecharmer.movementinterface.MovementInterface;
import com.lu.wang.snakecharmer.travelalgorithm.TravelAlgorithm;

public class SnakeCharmerApp {
	private static final Logger log = LoggerFactory.getLogger(SnakeCharmerApp.class);

	/**
	 * Constructor
	 */
	public SnakeCharmerApp() {
	}

	/**
	 * Run SnakeCharmer App application.
	 * 
	 * @param inFile  input file
	 * @param outFile output file
	 */
	public void run(File inFile, File outFile, boolean isTravelAlgorithm) {
		if (inFile.exists() == false || inFile.isFile() == false) {
			log.error("Invalid input file.");
		}
		if (outFile.exists() == false || inFile.isFile() == false) {
			log.error("Invalid input file.");
		}
		String readLine;
		BufferedReader br = null;
		BufferedWriter bw = null;
		MovementInterface algorithm;
		if (isTravelAlgorithm) {
			algorithm = new TravelAlgorithm();
		} else {
			algorithm = new DijkstraAlgorithm();
		}
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));

			while ((readLine = br.readLine()) != null) {
				log.debug("Destination from input file: " + readLine);

				String[] coordinates = readLine.trim().split(" ");
				if (coordinates.length != 2) {
					throw new Exception("Input file in wrong format");
				}

				String result = algorithm
						.calcMovement(new Node(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
				bw.write(result);
				bw.newLine();
				log.debug("Movement from [0,0] + " + readLine + " = " + result);
			}
		} catch (Exception e) {
			log.error("Error when read/write file.", e);
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				log.error("Error during closing: " + e.getMessage());
			}
		}
	}

	/**
	 * Main method for the application
	 */
	public static void main(String[] args) {
		log.info("Application started ...");

		if (args.length > 3 || args.length < 2) {
			log.error(
					"Usage: java com.lu.wang.snakecharmer.SnakeCharmerApp <inputFile> <outputFile> <1=TravelAlgorithm other=DijkstraAlgorithm>");
			System.exit(1);
		}
		String flag = "0";
		if (args.length == 3) {
			flag = args[2];
		}

		SnakeCharmerApp app = new SnakeCharmerApp();
		app.run(new File(args[0]), new File(args[1]), "1".equals(flag));

		log.info("Application stopped ...");
	}
}
