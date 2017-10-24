/**
 * 
 */
window.onload=
function loadImage()
{
	var x = document.getElementById('canvas');
	canvas = x.getContext('2d');
	
	var image = new Image();
	image.src='Tic.jpg';
	image.onload = function()
	{
		canvas.drawImage(image,330,170); 
	};
}
//window.addEventListener("load", loadImage, false);

function drawShape(z)
{
	var x = document.getElementById('canvas');
	canvas = x.getContext('2d');
	
	var image = new Image();
	image.src='Tic.jpg';
	switch(z)
	{
		case 3 :image.onload = function()
			{
			canvas.drawImage(image,330,170); 
			window.setInterval(gothree,1000);
			};
			break;
		case 4 : image.onload = function()
			{
			canvas.drawImage(image,330,170); 
			window.setInterval(gofour,1000);
			};
			break;
		case 5 : image.onload = function()
		{
			canvas.drawImage(image,330,170); 
			window.setInterval(gofive,1000);
		};
		break;
		case 6 : image.onload = function()
		{
			canvas.drawImage(image,330,170); 
			window.setInterval(gosix,1000);
		};
		break;
		case 7 : image.onload = function()
		{
			canvas.drawImage(image,330,170); 
			window.setInterval(goseven,1000);
		};
		break;
		case 8 : image.onload = function()
		{
			canvas.drawImage(image,330,170); 
			window.setInterval(goeigth,1000);
		};
		break;
		case 9 : image.onload = function()
		{
			canvas.drawImage(image,330,170); 
			window.setInterval(gonine,1000);
		};
		break;
		case 10 : image.onload = function()
		{
			canvas.drawImage(image,330,170); 
			window.setInterval(goten,1000);
		};
		break;
	}
}
function gothree()
{
		canvas.beginPath();
		canvas.moveTo(420,260);
		canvas.lineTo(810,260);
		canvas.closePath();
		canvas.stroke();
	
}
function gofour()
{
		canvas.beginPath();
		canvas.moveTo(460,210);
		canvas.lineTo(450,570);
		canvas.closePath();
		canvas.stroke();
	
}
function gofive()
{
		canvas.beginPath();
		canvas.moveTo(460,230);
		canvas.lineTo(780,550);
		canvas.closePath();
		canvas.stroke();
	
}
function gosix()
{
		canvas.beginPath();
		canvas.moveTo(790,230);
		canvas.lineTo(450,540);
		canvas.closePath();
		canvas.stroke();
	
}
function goseven()
{
		canvas.beginPath();
		canvas.moveTo(410,390);
		canvas.lineTo(810,385);
		canvas.closePath();
		canvas.stroke();
	
}
function goeight()
{
		canvas.beginPath();
		canvas.moveTo(410,525);
		canvas.lineTo(820,520);
		canvas.closePath();
		canvas.stroke();
	
}
function gonine()
{
		canvas.beginPath();
		canvas.moveTo(620,230);
		canvas.lineTo(620,550);
		canvas.closePath();
		canvas.stroke();
	
}
function goten()
{
		canvas.beginPath();
		canvas.moveTo(780,230);
		canvas.lineTo(795,550);
		canvas.closePath();
		canvas.stroke();
	
}
function drawCross(z)
{
	var x = document.getElementById('canvas');
	canvas = x.getContext('2d');
	var image = new Image();
	image.src='Tic.jpg';
	switch(z)
	{
	case 1 : image.onload = function()
	{
		canvas.drawImage(image,330,170);
		window.setInterval(crossone1,10);
		window.setInterval(crossone2,10);
		
	};
	break;
	case 2 : image.onload = function()
	{
		canvas.drawImage(image,330,170);
		window.setInterval(crosstwo1,10);
		window.setInterval(crosstwo2,10);
	};
	break;
	case 3 : image.onload = function()
	{
		canvas.drawImage(image,330,170);
		window.setInterval(crossthree1,10);
		window.setInterval(crossthree2,10);
	};
	break;
	case 4 : image.onload = function()
	{
		canvas.drawImage(image,330,170);
		window.setInterval(crossfour1,10);
		window.setInterval(crossfour2,10);
	};
	break;
	case 5 :image.onload = function()
	{
		canvas.drawImage(image,330,170);
		window.setInterval(crossfive1,10);
		window.setInterval(crossfive2,10);
	};
	break;
	case 6 : image.onload = function()
	{
		canvas.drawImage(image,330,170);
		window.setInterval(crosssix1,100);
		window.setInterval(crosssix2,100);
	}
	break;
	case 7 :image.onload = function()
	{
		canvas.drawImage(image,330,170);
		window.setInterval(crossseven1,100);
		window.setInterval(crossseven2,100);
	}
	break;
	case 8 : image.onload = function()
	{
		canvas.drawImage(image,330,170);
		window.setInterval(crosseight1,100);
		window.setInterval(crosseight2,100);
	}
	break;
	case 9 : image.onload = function()
	{
		canvas.drawImage(image,330,170);
		window.setInterval(crossnine1,100);
		window.setInterval(crossnine2,100);
	}
	}
}
function crossone1()
{
		canvas.beginPath();
		canvas.moveTo(420,220);
		canvas.lineTo(500,300);
		canvas.closePath();
		canvas.stroke();
	
}
function crossone2()
{
		canvas.beginPath();
		canvas.moveTo(500,220);
		canvas.lineTo(420,300);
		canvas.closePath();
		canvas.stroke();
	
}
function crosstwo1()
{
		canvas.beginPath();
		canvas.moveTo(580,220);
		canvas.lineTo(660,300);
		canvas.closePath();
		canvas.stroke();
	
}
function crosstwo2()
{
		canvas.beginPath();
		canvas.moveTo(660,220);
		canvas.lineTo(580,300);
		canvas.closePath();
		canvas.stroke();
	
}
function crossthree1()
{
		canvas.beginPath();
		canvas.moveTo(740,220);
		canvas.lineTo(820,300);
		canvas.closePath();
		canvas.stroke();
	
}
function crossthree2()
{
		canvas.beginPath();
		canvas.moveTo(820,220);
		canvas.lineTo(740,300);
		canvas.closePath();
		canvas.stroke();
	
}
function crossfour1()
{
		canvas.beginPath();
		canvas.moveTo(420,350);
		canvas.lineTo(500,430);
		canvas.closePath();
		canvas.stroke();
	
}
function crossfour2()
{
		canvas.beginPath();
		canvas.moveTo(500,350);
		canvas.lineTo(420,430);
		canvas.closePath();
		canvas.stroke();
	
}
function crossfive1()
{
		canvas.beginPath();
		canvas.moveTo(580,350);
		canvas.lineTo(660,430);
		canvas.closePath();
		canvas.stroke();
	
}
function crossfive2()
{
		canvas.beginPath();
		canvas.moveTo(660,350);
		canvas.lineTo(580,430);
		canvas.closePath();
		canvas.stroke();
	
}
function crosssix1()
{
		canvas.beginPath();
		canvas.moveTo(750,350);
		canvas.lineTo(830,430);
		canvas.closePath();
		canvas.stroke();
	
}
function crosssix2()
{
		canvas.beginPath();
		canvas.moveTo(820,350);
		canvas.lineTo(740,430);
		canvas.closePath();
		canvas.stroke();
	
}
function crossseven1()
{
		canvas.beginPath();
		canvas.moveTo(420,480);
		canvas.lineTo(490,575);
		canvas.closePath();
		canvas.stroke();
	
}
function crossseven2()
{
		canvas.beginPath();
		canvas.moveTo(510,480);
		canvas.lineTo(390,570);
		canvas.closePath();
		canvas.stroke();
	
}
function crosseight1()
{
		canvas.beginPath();
		canvas.moveTo(560,480);
		canvas.lineTo(650,570);
		canvas.closePath();
		canvas.stroke();
	
}
function crosseight2()
{
		canvas.beginPath();
		canvas.moveTo(640,480);
		canvas.lineTo(560,570);
		canvas.closePath();
		canvas.stroke();
	
}
function crossnine1()
{
		canvas.beginPath();
		canvas.moveTo(750,480);
		canvas.lineTo(850,570);
		canvas.closePath();
		canvas.stroke();
	
}
function crossnine2()
{
		canvas.beginPath();
		canvas.moveTo(830,480);
		canvas.lineTo(750,570);
		canvas.closePath();
		canvas.stroke();
	
}
function drawCircle(y)
{
	var x = document.getElementById('canvas');
	canvas = x.getContext('2d');
	var image = new Image();
	image.src='Tic.jpg';
	switch(y)
	{
		case 1 : image.onload = function()
		{
			canvas.drawImage(image,330,170);
			window.setInterval(cir1,100);
		}
		break;
		case 2 : image.onload = function()
		{
			canvas.drawImage(image,330,170);
			window.setInterval(cir2,100);
		}
		break;
		case 3 : image.onload = function()
		{
			canvas.drawImage(image,330,170);
			window.setInterval(cir3,100);
		}
		break;
		case 4 : image.onload = function()
		{
			canvas.drawImage(image,330,170);
			window.setInterval(cir4,100);
		}
		break;
		case 5 : image.onload = function()
		{
			canvas.drawImage(image,330,170);
			window.setInterval(cir5,100);
		}
		break;
		case 6 : image.onload = function()
		{
			canvas.drawImage(image,330,170);
			window.setInterval(cir6,100);
		}
		break;
		case 7 : image.onload = function()
		{
			canvas.drawImage(image,330,170);
			window.setInterval(cir7,100);
		}
		break;
		case 8 : image.onload = function()
		{
			canvas.drawImage(image,330,170);
			window.setInterval(cir8,100);
		}
		break;
		case 9 : image.onload = function()
		{
			canvas.drawImage(image,330,170);
			window.setInterval(cir9,100);
		}
	}
}
function cir1()
{
	canvas.beginPath();
	canvas.arc(450,250,38,0,2*Math.PI);
	canvas.stroke();
	
}
function cir2()
{
	canvas.beginPath();
	canvas.arc(610,250,38,0,2*Math.PI);
	canvas.stroke();
	
}
function cir3()
{
	canvas.beginPath();
	canvas.arc(770,250,38,0,2*Math.PI);
	canvas.stroke();
	
}
function cir4()
{
	canvas.beginPath();
	canvas.arc(450,390,38,0,2*Math.PI);
	canvas.stroke();
	
}
function cir5()
{
	canvas.beginPath();
	canvas.arc(610,390,38,0,2*Math.PI);
	canvas.stroke();
	
}
function cir6()
{
	canvas.beginPath();
	canvas.arc(770,390,38,0,2*Math.PI);
	canvas.stroke();
	
}
function cir7()
{
	canvas.beginPath();
	canvas.arc(450,520,38,0,2*Math.PI);
	canvas.stroke();
	
}
function cir8()
{
	canvas.beginPath();
	canvas.arc(610,520,38,0,2*Math.PI);
	canvas.stroke();
	
}
function cir9()
{
	canvas.beginPath();
	canvas.arc(770,520,38,0,2*Math.PI);
	canvas.stroke();
	
}