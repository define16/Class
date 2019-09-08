package main;

import DB.createSQL;
import Parser.textFiles;
import Parser.windowParser;
import Parser.xlsxParser;

public interface autoCon {
	createSQL csql = new createSQL();
	windowParser w = new windowParser();
	xlsxParser xparsing = new xlsxParser();
	textFiles tf = new textFiles();
	mining m = new mining();
}
