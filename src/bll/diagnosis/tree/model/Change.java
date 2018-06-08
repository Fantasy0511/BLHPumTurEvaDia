package bll.diagnosis.tree.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Change {
	private String time;
	private int unitNo;
	private String system;

	public static void write(ArrayList<Node> input) {
		StringBuffer sb = new StringBuffer();
		try {
			File f = new File("d:\\123.txt");
			// if(f.exists()){
			// System.out.print("文件存在");
			// }else{
			// System.out.print("文件不存在");
			// f.createNewFile();//不存在则创建
			// }
			// BufferedReader input = new BufferedReader(new FileReader(f));
			// ArrayList<Node> nodeList = excmain.InitialNodes();
			for (int j = 0; j < input.size(); j++) {
				String str = input.get(j).getName() + ",";
				str = str + input.get(j).getGate() + ",";
				str = str + input.get(j).getFreq() + ",";
				str = str + input.get(j).getFather() + ",";
				// NodeList children=nodeList.get(j).getChildren();
				for (int k = 0; k < input.get(j).getChildren().size(); k++) {
					// System.out.print(nodeList.get(j).getChildren().get(k));
					str = str + input.get(j).getChildren().get(k) + ",";
				}
				String newStr = str.substring(0, str.length() - 1);
				newStr = newStr + "\r\n";

				sb.append(newStr);
			}

			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(sb.toString());

			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void xiugainodes(ArrayList<Node> anodes) {

		ArrayList<Node> testnodes = new ArrayList<Node>();

		MakeFaultTree.InitialNodes(system,testnodes, time, unitNo);

		for (int p = 0; p < testnodes.size(); p++) {
			if (testnodes.get(p).getName().equals(anodes.get(0).getFather())) {

				String nstrn = anodes.get(0).getName();

				for (int k = 0; k < testnodes.size(); k++) {
					for (int j = 0; j < testnodes.get(k).getChildren()
							.size(); j++) {
						if (testnodes.get(k).getChildren().get(j)
								.equals(anodes.get(0).getFather())) {
							testnodes.get(k).getChildren().set(j, nstrn);
						}
					}
				}
				testnodes.get(p).setName(nstrn);
				testnodes.get(p).setGate(anodes.get(0).getGate());
				testnodes.get(p).setFreq(anodes.get(0).getFreq());
			}
		}
		Change.write(testnodes);
	}

	public void delnodes(String in) {

		ArrayList<Node> testnodes = new ArrayList<Node>();

		MakeFaultTree.InitialNodes(system,testnodes, time, unitNo);
		for (int k = 0; k < testnodes.size(); k++) {
			for (int j = 0; j < testnodes.get(k).getChildren().size(); j++) {
				if (testnodes.get(k).getChildren().get(j).equals(in)) {
					testnodes.get(k).getChildren().remove(j);
				}
			}
		}

		for (int p = 0; p < testnodes.size(); p++) {
			if (testnodes.get(p).getName().equals(in)) {
				if (testnodes.get(p).getChildren().size() != 0) {
					for (int i = 0; i < testnodes.get(p).getChildren()
							.size(); i++) {
						delnodes(testnodes.get(p).getChildren().get(i));

					}

				}

				testnodes.remove(p);
			}

		}
		Change.write(testnodes);
	}

	public void addnode(ArrayList<Node> anodes) {
		ArrayList<Node> testnodes = new ArrayList<Node>();

		MakeFaultTree.InitialNodes(system,testnodes, time, unitNo);

		Node addnode = new Node();
		String str = anodes.get(0).getName();

		addnode.setName(str);
		String str1 = anodes.get(0).getGate();

		addnode.setGate(str1);
		double d1 = anodes.get(0).freq;

		addnode.freq = d1;

		int num2 = anodes.get(0).getChildren().size();
		for (int j = 0; j < num2; j++) {

			addnode.children.add(anodes.get(0).getChildren().get(j));
		}
		testnodes.add(addnode);
		for (int k = 0; k < testnodes.size(); k++) {

			if (testnodes.get(k).getName().equals(anodes.get(0).getFather())) {
				testnodes.get(k).children.add(str);

			}

		}
		Change.write(testnodes);
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(int unitNo) {
		this.unitNo = unitNo;
	}

}