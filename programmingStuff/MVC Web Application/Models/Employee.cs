using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace MVC_Web_Application.Models
{
    [Table("Employeetbl")]
    public class Employee
    {
        [Key] // Primary Key
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        public string Position { get; set; }

        [ForeignKey("Department")]
        public int DepartmentId { get; set; }  // Foreign Key

        public virtual Department Department { get; set; }
    }
}