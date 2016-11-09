<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Json extends CI_Controller {



    var  $title=" ศูนย์ตะวันฉาย มหาวิทยาลัยขอนแก่น | TAWANCHAI KhoenKean University Version 1.0 "; //The Entrar-shadow Website form | w3layouts
    var  $title_fr1=" ระบบการติดตามการรักษา version 1.0 ";
	public function index()
	{
		//$this->load->view('welcome_message');
                $data['title']= $this->title;
                $this->load->view('login',$data);
	}
        
               #http://localhost/dental/index.php/json/json1
               public function json1()
               {
                    $tb="image";
                    $q=$this->db->get($tb);
                    foreach($q->result() as $row)
                    {
                        $rows[]=$row;
                    }
                    echo   json_encode($rows);
                    
                   
               }
              # http://localhost/dental/index.php/json/json2
               public function json2()
               {
                   $tb="member";
                   $q=$this->db->get($tb);
                     foreach($q->result() as $row)
                    {
                        $rows[]=$row;
                    }
                    echo   json_encode($rows);
               }
               
               
              
        
               # http://localhost/dental/index.php/json/json3
               public function json3()
               {
                   $tb= "customer";
                   $q=$this->db->get($tb);
                     foreach($q->result() as $row)
                    {
                        $rows[]=$row;
                    }
                    echo   json_encode($rows);
               }
               # http://localhost/dental/index.php/json/json4
               public function json4()
               {
                     $tb="sample";
                     $id=trim($this->input->get_post("id"));
                     $q=$this->db->get($tb);
                     foreach($q->result() as $row)
                    {
                        $rows[]=$row;
                    }
                    echo   json_encode($rows);
                     
               }
        
        
}

?>