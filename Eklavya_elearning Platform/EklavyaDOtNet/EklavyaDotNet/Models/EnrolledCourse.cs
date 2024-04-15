using System;
using System.Collections.Generic;

namespace EklavyaDotNet.Models
{
    public partial class EnrolledCourse
    {
        public long EnrollId { get; set; }
        public long? UId { get; set; }
        public string? Title { get; set; }
        public string? CType { get; set; }
        public long? CId { get; set; }
    }
}
