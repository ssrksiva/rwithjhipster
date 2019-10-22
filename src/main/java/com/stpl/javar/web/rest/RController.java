package com.stpl.javar.web.rest;

import org.springframework.web.bind.annotation.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import java.util.List;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.io.FileWriter;  

@RestController
@RequestMapping("/api")
public class RController {
   
@GetMapping("/createGraphs")
public  void rChartCreate() throws REXPMismatchException, IOException,RserveException {
    String output=null;
    try {
		/* startRstudio();*/
		/* startRserve();*/
        // make a new local connection on default port (6311)
        RConnection c = new RConnection();
   
        /* double d[] = c.eval("rnorm(10)").asDoubles();*/
         log(c);
         REXP x0 = c.eval("R.version.string");
        
         c.eval("library(plotly)");
         c.eval("set.seed(123)");
         
         c.eval("df <- diamonds[sample(1:nrow(diamonds), size = 1000),]");

         c.eval("p <- ggplot(df, aes(x = color)) + geom_bar(aes(y = ..count../sum(..count..), fill = cut)) + scale_fill_brewer(palette = 'Set3') +  ylab('Percent') + ggtitle('Show precentages in bar chart')");

         c.eval("p <- ggplotly(p)");
         System.out.println("Working Directory = " +
         System.getProperty("user.dir"));
         output=c.eval("paste(htmltools::tagList(list(config(p, displaylogo = FALSE,responsive= TRUE))))").asString();
         fileWriter("y.html",output);
         rChartCreateLineGraph(c);
         rChartCreate1(c);
         rChartCreatePieChart(c);
         System.out.println(x0.asString());
} catch (REngineException e) {
         //manipulation
	System.out.println(e.getMessage());
     }      
     
    
}

public  void rChartCreate1(RConnection c) throws REXPMismatchException, IOException,RserveException {
    String output=null;
    try {
		/* startRstudio();*/
		/* startRserve();*/
        // make a new local connection on default port (6311)
        
   
        /* double d[] = c.eval("rnorm(10)").asDoubles();*/
        
         REXP x0 = c.eval("R.version.string");
        
         c.eval("library(plotly)");
         c.eval("library(mongolite)");
         c.eval("my_collection = mongo(collection = 'population', db ='test_population')");
         
         c.eval("dat1 <- data.frame(dep = factor(c('Sales','Sales','Marketing','Marketing')),time = factor(c('Jan','Feb','Jan','Feb'), levels=c('Jan','Feb')), total_bill = c(13.53, 16.81, 16.24, 14))");

         c.eval("p <- ggplot(data=dat1, aes(x=time, y=total, fill=dep)) +geom_bar(stat='identity', position=position_dodge())+ggtitle('Dynamic Chart Generate')");

         c.eval("p <- ggplotly(p)");
         System.out.println("Working Directory = " +
         System.getProperty("user.dir"));
         output=c.eval("paste(htmltools::tagList(list(config(p, displaylogo = FALSE,responsive= TRUE))))").asString();
         fileWriter("c.html",output);
        
         System.out.println(x0.asString());
} catch (REngineException e) {
         //manipulation
	System.out.println(e.getMessage());
     }      
     
    
}
public void fileWriter(String fileName,String output){
    try{    
        FileWriter fw=new FileWriter(System.getProperty("user.dir")+"\\src\\main\\webapp\\content\\"+fileName,false);    
        fw.write("<!DOCTYPE html><html><head><meta charset='utf-8'/><script src='lib/htmlwidgets-1.3/htmlwidgets.js'></script><script src='lib/plotly-binding-4.9.0/plotly.js'></script><script src='lib/typedarray-0.1/typedarray.min.js'></script><script src='lib/jquery-1.11.3/jquery.min.js'></script><link href='lib/crosstalk-1.0.0/css/crosstalk.css' rel='stylesheet' /><script src='lib/crosstalk-1.0.0/js/crosstalk.min.js'></script><link href='lib/plotly-htmlwidgets-css-1.46.1/plotly-htmlwidgets.css' rel='stylesheet' /><script src='lib/plotly-main-1.46.1/plotly-latest.min.js'></script></head><body style='background-color:white;'>"+output+"</body></html>");    
        fw.close();    
       }catch(Exception e){System.out.println(e);}    
       System.out.println("Success...");    
  }    

public void rChartCreateLineGraph(RConnection c) throws REXPMismatchException, IOException,RserveException {
    String output=null;
    try {
		/* startRstudio();*/
		/* startRserve();*/
        // make a new local connection on default port (6311)
        /* double d[] = c.eval("rnorm(10)").asDoubles();*/
       
        
         
         REXP x0 = c.eval("R.version.string");
        
         c.eval("library(plotly)");
         c.eval("x <- c(1:100)");

         c.eval("random_y <- rnorm(100, mean = 0)");

         c.eval("data <- data.frame(x, random_y)");

         c.eval("p <- plot_ly(data, x = ~x, y = ~random_y, type = 'scatter', mode = 'lines')");
         output=c.eval("paste(htmltools::tagList(list(config(p, displaylogo = FALSE,responsive= TRUE))))").asString();
         fileWriter("z.html",output);
         System.out.println(x0.asString());
         
} catch (REngineException e) {
         //manipulation
	System.out.println(e.getMessage());
     }      
	
}
public void rChartCreatePieChart(RConnection c) throws REXPMismatchException, IOException,RserveException {
    String output=null;
    try {
		/* startRstudio();*/
		/* startRserve();*/
        // make a new local connection on default port (6311)
        /* double d[] = c.eval("rnorm(10)").asDoubles();*/
       
        
         
         REXP x0 = c.eval("R.version.string");
        
         c.eval("library(plotly)");
         c.eval("USPersonalExpenditure <- data.frame('Categorie'=rownames(USPersonalExpenditure), USPersonalExpenditure)");

         c.eval("data <- USPersonalExpenditure[,c('Categorie', 'X1960')]");

       

         c.eval("p <- plot_ly(data, labels = ~Categorie, values = ~X1960, type = 'pie') %>% layout(title = 'United States Personal Expenditures by Categories in 1960', xaxis = list(showgrid = FALSE, zeroline = FALSE, showticklabels = FALSE), yaxis = list(showgrid = FALSE, zeroline = FALSE, showticklabels = FALSE))");
         output=c.eval("paste(htmltools::tagList(list(config(p, displaylogo = FALSE,responsive= TRUE))))").asString();
         fileWriter("a.html",output);
         
         System.out.println(x0.asString());
         c.close();
} catch (REngineException e) {
         //manipulation
	System.out.println(e.getMessage());
     }      
	 
}

public static void log(RConnection rCon) {
    String msg = "";
    
    StringBuilder evalString = new StringBuilder();
    evalString.append("cat(\"[WPS4R @ ");
    evalString.append((new Date(System.currentTimeMillis())));
    evalString.append("] ");
    evalString.append(msg);
    evalString.append("\\n\")");
    
    try {
        rCon.eval(evalString.toString());
    }
    catch (RserveException e) {
        System.out.println("Could not log message '" + msg + "'");
    }
}
}