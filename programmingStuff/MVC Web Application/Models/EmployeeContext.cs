using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace MVC_Web_Application.Models
{
    public class EmployeeContext : DbContext
    {
        public EmployeeContext() : base("EmployeeDB") { }

        public DbSet<Employee> Employees { get; set; }
        public DbSet<Department> Departments { get; set; }
    }
}