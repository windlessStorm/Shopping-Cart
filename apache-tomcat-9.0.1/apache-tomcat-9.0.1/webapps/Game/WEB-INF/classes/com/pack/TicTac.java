package com.pack;

public class TicTac {
	public char t[][]=new char[3][3];
	TicTac()
	{
		int z,x;
		for(z=0;z<3;z++)
		{
			for(x=0;x<3;x++)
				t[z][x]=' ';
		
		}

	}
	public void refresh() {
		int z,x;
		for(z=0;z<3;z++)
		{
			for(x=0;x<3;x++)
				t[z][x]=' ';
		}
	}
	public int insert(int a,int b,int z)
	{
			if(a<3 && b<3)
			{
				if(t[a][b]==' ')
				{
					if(z%2==0)
					{
						t[a][b]='0';
						return 1;
					}
					else
					{
						t[a][b]='X';
						return 1;
					}
				}
				else
				{
					return 0;
				}
			}
			else
			{
				return 0;
			}
	}


	public int insertAI(int a,int b)
	{
			if(a<3 && b<3)
			{
				if(t[a][b]==' ')
				{
						t[a][b]='X';
						return 1;
				}
				else
				{
					return 0;
				}
			}
			else
			{
				return 0;
			}

	} 
	
	
	
	
	public int[] checkIt()
	{
		int m,n,count=0,chek=t[0][0],check=t[0][2],d=1,ret[] = {1 , 2};
		char w;
		for(m=0;m<3;m++)
		{
			count=0;
			for(n=1;n<3;n++)
			{
				if(t[m][0]==t[m][n])
					count++;
			}
			if(count==2)
			{
				w=t[m][0];
				if(w!=' ')
				{
					if(m==0)
						ret [0] = 3;
					else if(m==1)
						ret [0] = 7;
					else
						ret [0] = 8;
					
					if(w=='X')
					{
						 ret[1] = 1;
						 return ret;
					}
					else
					{
						  ret[1] = 2;
						  return ret;
					}
				}
			}
			count=0;
			for(n=1;n<3;n++)
			{
				if(t[0][m]==t[n][m])
					count++;
			}
			if(count==2)
			{
				w=t[0][m];
				if(m==0)
					ret [0] = 4; 
				else if(m==1)
					ret [0] = 9; 
				else 
					ret [0] = 10; 
				
					if(w!=' ')
					{
						if(w=='X')
						{
							ret[1] = 1;
							return ret;
						}
					
						else
						{
							ret[1] = 2;
							return ret;	
						}
					}
			}
			count=0;
			for(n=1;n<3;n++)
			{
				if(t[n][n]==chek)
					count++;
			}
			if(count==2)
			{
				w=t[0][0];
				ret [0] = 5; 
				if(w!=' ')
				{
					if(w=='X')
					{
						ret[1] = 1;
						return ret;
					}
					else
					{
						ret[1] = 2;
						return ret;
					}
				}
			}
			count=0;
			d=1;
			for(n=1;n<3;n++)
			{
			if(t[n][d]==check)
				count++;
			d--;
			}
			if(count==2)
			{
				w=t[1][1];
				ret [0] = 6; 
				if(w!=' ')
				{
					if(w=='X')
					{
						ret[1] = 2;
						return ret;
					}
					else
					{
						ret[1] = 2;
						return ret;
					}
				}
			}

		}
		ret[1] = 0;
		return ret;
	}

	
int move()
{
	if(t[1][1]==' ')
	{
		t[1][1]='0';
		return 1;
	}
	for(int i=0;i<=2;)
	{
		if(t[i][0]==' ')
		{
			t[i][0]='0';
			return 1;
		}
		if(t[i][2]==' ')
		{
			t[i][2]='0';
			return 1;
		}
		i+=2;
	}
	for(int i=0;i<=1;i++)
	{
		int j=1;
		if(t[i][j]==' ')
		{
			t[i][j]='0';
			return 1;
		}
		if(t[j][i]==' ')
		{
			t[j][i]='0';
			return 1;
		}
		j++;
	}
return 0;
}
}
