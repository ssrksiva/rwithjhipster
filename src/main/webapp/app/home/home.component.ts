import { Component, OnInit,AfterViewInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { GridsterConfig, GridsterItem, GridsterItemComponentInterface } from 'angular-gridster2';
import { LoginModalService, Principal, Account } from 'app/core';
import { Pipe, PipeTransform,Renderer2 } from '@angular/core';
import { DomSanitizer, SafeHtml, SafeStyle, SafeScript, SafeUrl, SafeResourceUrl} from '@angular/platform-browser';
import { HttpClient } from '@angular/common/http';
import { Directive, ElementRef } from '@angular/core';
@Pipe({
  name: 'safe'
})
export class SafePipe implements PipeTransform {

  constructor(protected sanitizer: DomSanitizer) {}
 
 public transform(value: any, type: string): SafeHtml | SafeStyle | SafeScript | SafeUrl | SafeResourceUrl {
   console.log(`Pipe Called!`);
    switch (type) {
			case 'html': return this.sanitizer.bypassSecurityTrustHtml(value);
			case 'style': return this.sanitizer.bypassSecurityTrustStyle(value);
			case 'script': return this.sanitizer.bypassSecurityTrustScript(value);
			case 'url': return this.sanitizer.bypassSecurityTrustUrl(value);
			case 'resourceUrl': return this.sanitizer.bypassSecurityTrustResourceUrl(value);
			default: throw new Error(`Invalid safe type specified: ${type}`);
		}
  }
}
@Component({
    selector: 'jhi-home',
    templateUrl: './home.component.html',
    styleUrls: ['home.css']
})
export class HomeComponent implements OnInit,AfterViewInit {
  
    account: Account;
    modalRef: NgbModalRef;
    loadData=true;
    isDataAvailable:boolean = false;
    isDataAvailable1 =false;
    isDataAvailable2 =false;
    output:any=[];
    text1='';
    zt= '<iframe src="../content/z.html" style="width:100%;height:100%"></iframe>';
     yt= '<iframe src="../content/y.html" style="width:100%;height:100%"></iframe>';
      at= '<iframe src="../content/a.html" style="width:100%;height:100%"></iframe>';
       
        ct= '<iframe src="../content/c.html" style="width:100%;height:100%"></iframe>';
 public options: GridsterConfig;
      public items: GridsterItem[];
	 
	 text="";
     


    constructor(private principal: Principal, private loginModalService: LoginModalService, private eventManager: JhiEventManager,private renderer: Renderer2,private httpClient: HttpClient) {
		 this.items = [{x: 0, y: 0, rows: 2.4, cols: 4,id: 0},
          {x: 0, y: 0, rows: 2.4, cols: 4,id: 1},
          {x: 0, y: 0, rows: 2.4, cols: 4,id: 2},
          {x: 0, y: 2.5, rows: 2.4, cols: 4,id: 4}];

        this.options = {
          pushItems: true,
          minCols: 12,
          maxCols: 18,
          minRows: 5,
          fixedRowHeight: 120,
          setGridSize: true,
          mobileBreakpoint: 0,
          gridType: 'fit',
         
          draggable: {
              enabled: true
          },
           resizable: {
              enabled: true
          },
       };
        
       
	}

    ngOnInit() {
        
        this.principal.identity().then(account => {
            this.account = account;
        });
        this.registerAuthenticationSuccess();
       
    }
ngAfterViewInit(){
    this.httpClient.get('/api/createGraphs').subscribe((data:any)=>
   {
    console.log(data);
    

     this.isDataAvailable=true;
   });
  
 
    
}
generate()
{
      this.httpClient.post('/api/createLineGraph',this.text1).subscribe((data:any)=>
   {
    console.log(data);
    

     this.loadData=true;
   });
}
    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', message => {
            this.principal.identity().then(account => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }
	add()
	{

	     
	}
	update()
	{
	    
	}
	delete()
	{
	    
	}
}
